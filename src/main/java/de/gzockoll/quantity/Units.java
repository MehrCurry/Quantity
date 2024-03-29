package de.gzockoll.quantity;

public enum Units implements Unit {
	KWH,SMS,KG;

	public Quantity amount(long l) {
		return new AbstractQuantity<Long>(l,this);
	}

	@Override
	public Quantity getZeroQuantity() {		
		return amount(0);
	}
}