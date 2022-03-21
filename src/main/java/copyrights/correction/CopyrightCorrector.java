package copyrights.correction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CopyrightCorrector
{
    static FileHandler handler = null;
    static Logger logger = null;
    static List<String> skippedFileList = new ArrayList<>();
    static int fileCountWith2022 = 0;
    static int fileUpdatedCount = 0;
    static String NEW_COPYRIGHT_FIRST_LINE_TEMPLATE = " * Copyright (c) ## Micro Focus or one of its affiliates.  All Rights Reserved.\n";
    static String NEW_COPY_RIGHT_TEMPLATE = "/*\n" +
            " * Copyright (c) ## Micro Focus or one of its affiliates.  All Rights Reserved.\n" +
            " *\n" +
            " *   THIS WORK IS AN UNPUBLISHED WORK AND CONTAINS CONFIDENTIAL PROPRIETARY\n" +
            " *   AND TRADE SECRET INFORMATION OF MICRO FOCUS SOFTWARE INC. ACCESS  TO  THIS\n" +
            " *   WORK IS RESTRICTED TO (I) MICRO FOCUS SOFTWARE INC. EMPLOYEES WHO HAVE A NEED\n" +
            " *   TO  KNOW HOW TO  PERFORM  TASKS WITHIN  THE SCOPE  OF  THEIR   ASSIGNMENTS\n" +
            " *   AND (II) ENTITIES OTHER  THAN  MICRO FOCUS SOFTWARE INC.  WHO  HAVE ENTERED\n" +
            " *   INTO APPROPRIATE LICENSE   AGREEMENTS.  NO  PART  OF  THIS WORK MAY BE USED,\n" +
            " *   PRACTICED, PERFORMED COPIED, DISTRIBUTED, REVISED, MODIFIED, TRANSLATED, ABRIDGED,\n" +
            " *   CONDENSED, EXPANDED, COLLECTED, COMPILED, LINKED,  RECAST, TRANSFORMED\n" +
            " *   OR ADAPTED  WITHOUT THE PRIOR WRITTEN CONSENT OF MICRO FOCUS SOFTWARE INC.\n" +
            " *   ANY USE OR EXPLOITATION  OF  THIS WORK WITHOUT AUTHORIZATION COULD SUBJECT\n" +
            " *   THE PERPETRATOR  TO CRIMINAL AND CIVIL LIABILITY.\n" +
            " */";
    
    public static void main(String[] args) throws IOException
    {
        try
        {
            handler = new FileHandler("copyrights_correction_6.log", true);
    
            logger = Logger.getLogger("copyrights.correction");
            logger.addHandler(handler);
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(true);
            // Expecting CSV file in format : Source File Name,CopyRight Year,Author
            String csvFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "copyrights-spoke.csv";
            String sourceCodeStartPath = "D:" + File.separator + "GIT_HUB" + File.separator + "server-spoke" + File.separator;
            List<String> fileListForUpdatingCopyrights = getListOfFilesToBeCorrected(csvFilePath, sourceCodeStartPath);
            processFiles(fileListForUpdatingCopyrights);
            
            //String fullFilePathCore = "D:" + File.separator + "GIT_HUB" + File.separator + "server-core" + File.separator + currentFilePath;
            //String csvFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "copyrights-core.csv";
            //List<String> singleFile = Collections.singletonList(fileListForUpdatingCopyrights.get(0));
            //processFiles(singleFile);
        }
        catch(Exception t)
        {
            logger.log(Level.SEVERE, "unknown Error occurred", t);
        }
        finally
        {
            logger.log(Level.FINEST, "fileCountWith2022 : {0}", fileCountWith2022);
            logger.log(Level.FINEST, "fileUpdatedCount : {0}", fileUpdatedCount);
            logger.log(Level.FINEST, "Skipped file list : {0}", skippedFileList);
            skippedFileList.forEach(System.out::println);
        }
    }
    
    private static void processFiles(List<String> fileListForUpdatingCopyrights)
    {
        int processedCount = 0;
        for (String currentFilePath : fileListForUpdatingCopyrights)
        {
            logger.log(Level.FINE, "-----Correcting copyright for the file: {0}", currentFilePath);
            try
            {
                processFile(currentFilePath);
                processedCount++;
            }
            catch(IOException e)
            {
                logger.log(Level.SEVERE,String.format("error while updating the copyright for the file: %s", currentFilePath), e);
                skippedFileList.add(currentFilePath);
            }
        }
        logger.log(Level.FINEST, "processedCount : {0}", processedCount);
    }
    
    private static List<String> getListOfFilesToBeCorrected(String csvFilePath, String sourceCodeStartPath)
    {
        Path path = Paths.get(csvFilePath);
        List<String> filePathsToBeCorrected = new ArrayList<>();
        try(Stream<String> input = Files.lines(path))
        {
            input.map(s -> s.split(",")[0])
                    .filter(s -> s.contains("/"))
                    .map(s -> s = sourceCodeStartPath + s )
                    .forEach(filePathsToBeCorrected::add);
        }
        catch(IOException e)
        {
            logger.log(Level.SEVERE,"error while getting the files to be corrected from the csv", e);
        }
        return filePathsToBeCorrected;
    }
    
    static void processFile(String filePath) throws IOException
    {
        String fileData = readFileData(filePath);
        int index = fileData.indexOf("package ");
        logger.log(Level.FINE, "index of the package line : {0}", index);
        String originalCopyrightText = getOriginalCopyrightText(fileData, index);
        String updatedCopyrightText = updateCopyright(originalCopyrightText);
        writeUpdatedCopyrightToFile(filePath, fileData, originalCopyrightText, updatedCopyrightText);
    }
    
    private static void writeUpdatedCopyrightToFile(String filePath, String fileData, String originalCopyrightText, String updatedCopyrightText) throws IOException
    {
        if (originalCopyrightText.isEmpty())
        {
            logger.log(Level.FINE, "Since there is no copyright available adding new copyright: {0}", updatedCopyrightText);
            fileData = updatedCopyrightText + "\n" + fileData;
            Files.write(Paths.get(fileData), fileData.getBytes(StandardCharsets.UTF_8));
        }
        else if (updatedCopyrightText !=null && !updatedCopyrightText.isEmpty() &&!updatedCopyrightText.equals(originalCopyrightText))
        {
            logger.log(Level.FINE, "-----replacing new copyright : {0}", updatedCopyrightText);
            fileData = fileData.replace(originalCopyrightText, updatedCopyrightText);
            fileUpdatedCount++;
            Files.write(Paths.get(filePath), fileData.getBytes(StandardCharsets.UTF_8));
        }
        else
        {
            logger.log(Level.FINE, "Nothing to update so not writing to file: {0}", filePath);
        }
    }
    
    private static String getOriginalCopyrightText(String fileData, int index)
    {
        String originalCopyrightText;
        if (index > 0)
        {
            originalCopyrightText = fileData.substring(0, index -1);
        }
        else
        {
            logger.log(Level.INFO, "Since there is no copyright available set originalCopyrightText as empty");
            originalCopyrightText = "";
        }
        logger.log(Level.FINE, "-----original  copyright : {0}", originalCopyrightText);
        return originalCopyrightText;
    }
    
    private static String readFileData(String filePath) throws IOException
    {
        logger.log(Level.FINE, "-----Reading data from file : {0}", filePath);
        String fileData = new String(Files.readAllBytes(Paths.get(filePath)));
        logger.log(Level.FINE, "fileEOL : {0}", Arrays.toString(fileData.substring(fileData.length()-1).getBytes(StandardCharsets.UTF_8)));
        return fileData;
    }
    
    static String updateCopyright(String copyrightText)
    {
        logger.log(Level.FINE, "Updating copyright");
        if(copyrightText == null || copyrightText.isEmpty())
        {
            logger.log(Level.FINE, "no copyright found so adding with current year");
            return NEW_COPY_RIGHT_TEMPLATE.replace("##", "2022");
        }
        
        if (copyrightText.contains("2022"))
        {
            fileCountWith2022++;
            logger.log(Level.FINE, "copyright with current year exists");
            return "";
        }
    
        boolean isOldCopyright = false;
        String[] arr = copyrightText.split("\\n");
        List<String> yearsFound = new ArrayList<>();
        StringJoiner copyrightBuilder = new StringJoiner("\n");
    
        for(String line : arr)
        {
            if (line.contains("Copyright (c)"))
            {
                getYearsFromCopyrightLine(yearsFound, line);
                if (line.contains("Novell"))
                {
                    isOldCopyright = true;
                    break;
                }
                else
                {
                    line = appendLatestYearInNewCopyrights(yearsFound, line);
                }
            }
            copyrightBuilder.add(line);
        }
    
        if (isOldCopyright)
        {
            logger.log(Level.FINE, "old copyright found replacing with the new one");
            return NEW_COPY_RIGHT_TEMPLATE.replace("##", yearsFound.get(0) + "-2022");
        }
        return copyrightBuilder.toString();
    }
    
    private static String appendLatestYearInNewCopyrights(List<String> yearsFound, String line)
    {
        if (yearsFound.size() == 1)
            line = line.replace(yearsFound.get(0), yearsFound.get(0) + "-2022");
        if (yearsFound.size() > 1)
        {
            if (line.contains(","))
            {
                line = NEW_COPYRIGHT_FIRST_LINE_TEMPLATE.replace("##", yearsFound.get(0) + "-2022");
            }
            else
            {
                line = line.replace(yearsFound.get(0) + "-" + yearsFound.get(1), yearsFound.get(0) + "-2022");
            }
        }
        return line;
    }
    
    private static void getYearsFromCopyrightLine(List<String> yearsFound, String line)
    {
        Pattern p = Pattern.compile("\\d{4}");
        Matcher m = p.matcher(line);
        while(m.find())
        {
            yearsFound.add(m.group());
        }
    }
}
