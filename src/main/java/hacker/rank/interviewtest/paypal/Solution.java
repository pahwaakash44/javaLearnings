package hacker.rank.interviewtest.paypal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;


/*
 * Create TransactionException, DigitalWallet, and DigitalWalletTransaction classes here.
 */
public class Solution
{
    private static final Scanner INPUT_READER = new Scanner(System.in);
    private static final DigitalWalletTransaction DIGITAL_WALLET_TRANSACTION = new DigitalWalletTransaction();

    private static final Map<String, DigitalWallet> DIGITAL_WALLETS = new HashMap<>();

    public static void main(String[] args) {
        int numberOfWallets = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfWallets-- > 0) {
            String[] wallet = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet;

            if (wallet.length == 2) {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1]);
            } else {
                digitalWallet = new DigitalWallet(wallet[0], wallet[1], wallet[2]);
            }

            DIGITAL_WALLETS.put(wallet[0], digitalWallet);
        }

        int numberOfTransactions = Integer.parseInt(INPUT_READER.nextLine());
        while (numberOfTransactions-- > 0) {
            String[] transaction = INPUT_READER.nextLine().split(" ");
            DigitalWallet digitalWallet = DIGITAL_WALLETS.get(transaction[0]);

            if (transaction[1].equals("add")) {
                try {
                    DIGITAL_WALLET_TRANSACTION.addMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully credited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            } else {
                try {
                    DIGITAL_WALLET_TRANSACTION.payMoney(digitalWallet, Integer.parseInt(transaction[2]));
                    System.out.println("Wallet successfully debited.");
                } catch (TransactionException ex) {
                    System.out.println(ex.getErrorCode() + ": " + ex.getMessage() + ".");
                }
            }
        }

        System.out.println();

        DIGITAL_WALLETS.keySet()
                .stream()
                .sorted()
                .map((digitalWalletId) -> DIGITAL_WALLETS.get(digitalWalletId))
                .forEachOrdered((digitalWallet) -> {
                    System.out.println(digitalWallet.getWalletId()
                            + " " + digitalWallet.getUsername()
                            + " " + digitalWallet.getWalletBalance());
                });
    }
}
class TransactionException extends Exception
{
    private String errorMsg;
    private String errorCode;

    public TransactionException(String errorCode, String errorMsg)
    {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public String getErrorCode()
    {
        return errorCode;
    }
}

class DigitalWallet
{
    private String walletId;
    private String username;
    private String accessCode;
    private int walletBalance;

    public DigitalWallet(String walletId, String username)
    {
        this.walletId = walletId;
        this.username = username;
    }

    public DigitalWallet(String walletId, String username, String accessCode)
    {
        this.walletId = walletId;
        this.username = username;
        this.accessCode = accessCode;
    }

    public String getWalletId()
    {
        return walletId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getAccessCode()
    {
        return accessCode;
    }

    public int getWalletBalance()
    {
        return walletBalance;
    }

    public void setWalletBalance(int walletBalance)
    {
        this.walletBalance = walletBalance;
    }
}

class DigitalWalletTransaction
{
    Predicate<String> testStringNotNullOrEmpty = string -> string != null && string.isEmpty();
    Predicate<Integer> testIntGreaterThanZero = integer -> integer > 0;

    public void addMoney(DigitalWallet digitalWallet, int amount) throws TransactionException
    {
        if (testStringNotNullOrEmpty.test(digitalWallet.getAccessCode()))
            throw new TransactionException("USER_NOT_AUTHORIZED", "User not authorized");
        if (testIntGreaterThanZero.test(amount))
            throw new TransactionException("INVALID_AMOUNT", "Amount should be greater than zero");
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() + amount);
    }

    public void payMoney(DigitalWallet digitalWallet, int amount) throws TransactionException
    {
        if (testStringNotNullOrEmpty.test(digitalWallet.getAccessCode()))
            throw new TransactionException(ExceptionConstants.USER_NOT_AUTHORIZED.toString(), "User not authorized");
        if (testIntGreaterThanZero.test(amount))
            throw new TransactionException("INVALID_AMOUNT", "Amount should be greater than zero");
        if (digitalWallet.getWalletBalance() - amount < 0)
            throw new TransactionException("INSUFFICIENT_BALANCE", "Insufficient balance");
        digitalWallet.setWalletBalance(digitalWallet.getWalletBalance() - amount);
    }
}

enum ExceptionConstants
{
    USER_NOT_AUTHORIZED("User not authorized"),
    INVALID_AMOUNT("Amount should be greater than zero"),
    INSUFFICIENT_BALANCE("Insufficient balance");

    private final String errorMsg;

    ExceptionConstants(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }
}