package com.nucleus.receipt.dao;

import com.nucleus.receipt.model.Receipt;

import java.util.List;

public interface ReceiptDAOInterface {

    Boolean createNewReceipt(Receipt receipt);
    List<Object> receiptSearch(String receiptType, String receiptBasis, Integer accountNumber, Integer receiptNo);
}
