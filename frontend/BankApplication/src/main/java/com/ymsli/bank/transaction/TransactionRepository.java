package com.ymsli.bank.transaction;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    /**
     * Pagination SAFE (no fetch join).
     */
    Page<Transaction> findByAccount_AccountNumber(
            String accountNumber,
            Pageable pageable
    );

    /**
     * Pending approvals (fetch join SAFE → List).
     */
    @Query("""
        select t from Transaction t
        join fetch t.account
        join fetch t.performedBy
        where t.status = 'PENDING_APPROVAL'
    """)
    
    List<Transaction> findPendingApprovalsWithDetails();
    @Query("""
    	    select t from Transaction t
    	    join fetch t.account
    	    join fetch t.performedBy
    	    where t.status = 'PENDING_APPROVAL'
    	""")
    	List<Transaction> findPendingApprovalsWithDetails1();

    /**
     * Single transaction with full graph.
     */
    @EntityGraph(attributePaths = {
            "account",
            "performedBy",
            "approvedBy"
    })
    @Query("select t from Transaction t where t.id = :id")
    Transaction findDetailedById(@Param("id") Long id);
}
