package com.ally.invoicify.models;

public class InvoiceView {
	private String invoiceDescription;
	private Integer[] recordIds;
	
	public InvoiceView(String invoiceDescription, Integer[] recordIds) {
		this.invoiceDescription = invoiceDescription;
		this.recordIds = recordIds;
	}

	public String getInvoiceDescription() {
		return invoiceDescription;
	}

	public void setInvoiceDescription(String invoiceDescription) {
		this.invoiceDescription = invoiceDescription;
	}

	public Integer[] getRecordIds() {
		return recordIds;
	}
}
