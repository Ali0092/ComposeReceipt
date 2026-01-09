package com.receiptui.modals

/**
 * Data model representing a single section within a sectioned list.
 * Groups a section title with its associated items.

 * @param T The type of items in this section. Can be any type (String, custom data class, etc.)
 * @param title The header text displayed for this section
 * @param items List of items belonging to this section. Can be empty to represent a section
 *              with no content (useful for placeholder states or progressive loading)
 */
data class ZapSectionData<T>(
    val title: String,
    val items: List<T>,
)
