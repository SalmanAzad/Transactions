package com.bank.transactions.model

import java.time.LocalDateTime

data class TransactionRequest(val customerId: String, val amount: Double)

data class TransactionResponse(
  val timestamp: LocalDateTime,
  val transactionId: String,
  val customerId: String,
  val amount: Double,
)
