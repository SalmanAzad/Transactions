package com.bank.transactions.service

import com.bank.transactions.model.TransactionRequest
import com.bank.transactions.model.TransactionResponse
import java.time.LocalDateTime
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class TransactionService {
  private val transactions = mutableMapOf<String, MutableList<TransactionResponse>>()

  // This is temporary implementation
  // Below method should actually create a transaction in database
  fun createTransaction(request: TransactionRequest): TransactionResponse? {
    val transaction =
      TransactionResponse(
        LocalDateTime.now(),
        UUID.randomUUID().toString(),
        request.customerId,
        request.amount
      )
    transactions.computeIfAbsent(request.customerId) { mutableListOf() }.add(transaction)
    return transaction
  }

  // This is temporary implementation
  // Below method should actually fetch transactions from database
  fun getTransactions(customerID: String): List<TransactionResponse> {
    return transactions[customerID] ?: emptyList()
  }
}
