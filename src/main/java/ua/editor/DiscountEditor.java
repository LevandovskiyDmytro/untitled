package ua.editor;

import java.beans.PropertyEditorSupport;
import ua.entities.Discount;
import ua.service.DiscountService;

public class DiscountEditor extends PropertyEditorSupport{
	private final DiscountService discountService;

	public DiscountEditor(DiscountService discountService) {
		this.discountService = discountService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Discount discount = discountService.findOne(Integer.valueOf(text));
		setValue(discount);
	}
}