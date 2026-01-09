package com.receiptui.modals

/**
 * Main data model containing all receipt content including sections, total, and description.
 */
data class ReceiptData(
    val sectionsData: List<ZapSectionData<ReceiptSectionData>>? = null,
    val totalSectionData: ReceiptSectionData? = null,
    val descriptionSectionData: ReceiptSectionData? = null,
    val canShowSectionSeparator: Boolean = false
)