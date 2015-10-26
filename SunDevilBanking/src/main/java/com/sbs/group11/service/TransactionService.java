package com.sbs.group11.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbs.group11.model.Account;
import com.sbs.group11.model.PaymentRequest;
import com.sbs.group11.model.StatementMonthYear;
import com.sbs.group11.model.Transaction;
import com.sbs.group11.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface TransactionService.
 */
public interface TransactionService {

	/**
	 * Adds the transaction.
	 *
	 * @param transaction
	 *            the transaction
	 */
	void addTransaction(Transaction transaction);

	/**
	 * Gets the unique transaction id.
	 *
	 * @return the unique transaction id
	 */
	String getUniqueTransactionID();

	/**
	 * Gets the big decimal.
	 *
	 * @param accNumber
	 *            the acc number
	 * @return the big decimal
	 */
	BigDecimal getBigDecimal(String accNumber);

	/**
	 * Gets the statement months.
	 *
	 * @param accNumber
	 *            the acc number
	 * @return the statement months
	 */
	List<StatementMonthYear> getStatementMonths(String accNumber);

	/**
	 * Gets the completed transactions by account nummber.
	 *
	 * @param accNumber
	 *            the acc number
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 * @return the completed transactions by account nummber
	 */
	List<Transaction> getCompletedTransactionsByAccountNummber(
			String accNumber, String month, int year);

	/**
	 * Gets the transaction.
	 *
	 * @param transactionID
	 *            the transaction id
	 * @return the transaction
	 */
	Transaction getTransaction(String transactionID);

	/**
	 * Gets the pending transactions.
	 *
	 * @return the pending transactions
	 */
	List<Transaction> getPendingTransactions();

	/**
	 * Gets the pending critical transaction.
	 *
	 * @return the pending critical transaction
	 */
	public List<Transaction> getPendingCriticalTransaction();

	/**
	 * Approve transaction.
	 *
	 * @param transactionID
	 *            the transaction id
	 * @return true, if successful
	 */
	boolean approveTransaction(String transactionID);

	/**
	 * Decline transaction.
	 *
	 * @param transactionID
	 *            the transaction id
	 */
	void declineTransaction(String transactionID);

	/**
	 * Modify transaction.
	 *
	 * @param transaction
	 *            the transaction
	 */
	void modifyTransaction(Transaction transaction);

	/**
	 * Checks if is transfer account valid.
	 *
	 * @param accountService
	 *            the account service
	 * @param transactionService
	 *            the transaction service
	 * @param senderAccounts
	 *            the sender accounts
	 * @param request
	 *            the request
	 * @param model
	 *            the model
	 * @param user
	 *            the user
	 * @param attr
	 *            the attr
	 * @return true, if is transfer account valid
	 */
	boolean isTransferAccountValid(AccountService accountService,
			TransactionService transactionService,
			List<Account> senderAccounts, HttpServletRequest request,
			ModelMap model, User user, RedirectAttributes attr);

	/**
	 * Initiate payment. Creates the payment request and notifies other users about it.
	 *
	 * @param paymentRequest the payment request
	 */
	void initiatePayment(PaymentRequest paymentRequest);

	/**
	 * Accept payment i.e. the user/merchant accepts the payment request made by
	 * the other
	 *
	 * @param paymentRequest the payment request
	 */
	void acceptPayment(PaymentRequest paymentRequest);

	/**
	 * Complete payment i.e. after the payment has been accepted by both
	 * parties, it is completed and added to transactions as pending for
	 * internal user to accept
	 *
	 * @param paymentRequest the payment request
	 */
	void completePayment(PaymentRequest paymentRequest);
	
	List<PaymentRequest> getPaymentsByAccNumber(String accNumber);

}
