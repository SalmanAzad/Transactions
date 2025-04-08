package com.bank.transactions.controller

import com.bank.transactions.model.TransactionRequest
import com.bank.transactions.model.TransactionResponse
import com.bank.transactions.service.TransactionService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/transactions")
@Tag(name = "Transaction API", description = "Handles transaction creation and retrieval")
class TransactionController(private val transactionService: TransactionService) {

  @Operation(summary = "Create a new transaction")
  @ApiResponses(
    value =
      [
        ApiResponse(responseCode = "200", description = "Transaction created successfully"),
        ApiResponse(responseCode = "400", description = "Invalid input"),
        ApiResponse(responseCode = "500", description = "Internal server error")
      ]
  )
  @PostMapping("/create")
  fun createTransaction(
    @RequestBody request: TransactionRequest
  ): ResponseEntity<TransactionResponse> {
    val response = transactionService.createTransaction(request)
    return ResponseEntity.ok(response)
  }

  @Operation(summary = "Get transactions for a specific customer ID")
  @ApiResponses(
    value =
      [
        ApiResponse(responseCode = "200", description = "Transactions retrieved"),
        ApiResponse(responseCode = "404", description = "Transactions not found for customer"),
        ApiResponse(responseCode = "500", description = "Internal server error")
      ]
  )
  @GetMapping("/customerId/{customerId}")
  fun getTransactions(@PathVariable customerId: String): ResponseEntity<List<TransactionResponse>> {
    val transactions = transactionService.getTransactions(customerId)
    return ResponseEntity.ok(transactions)
  }
}
