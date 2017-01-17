package com.bean;

import java.sql.Date;

public class Borrow {
	
	private long borrowid;
	private String rdID;
	private int bkID;
	private int idcontinuetimes;
	private Date iddateout;
	private Date iddateretplan;
	private Date iddateretact;
	private int idoverday;
	private float idOvermoney;
	private float idpunishmoney;
	private boolean ishasreturn;
	private String operatorlend;
	private String operatorret;
	
	public Borrow(){}

	public long getBorrowid() {
		return borrowid;
	}

	public void setBorrowid(long borrowid) {
		this.borrowid = borrowid;
	}

	public String getRdID() {
		return rdID;
	}

	public void setRdID(String rdID) {
		this.rdID = rdID;
	}

	public int getBkID() {
		return bkID;
	}

	public void setBkID(int bkID) {
		this.bkID = bkID;
	}

	public int getIdcontinuetimes() {
		return idcontinuetimes;
	}

	public void setIdcontinuetimes(int idcontinuetimes) {
		this.idcontinuetimes = idcontinuetimes;
	}

	public Date getIddateout() {
		return iddateout;
	}

	public void setIddateout(Date iddateout) {
		this.iddateout = iddateout;
	}

	public Date getIddateretplan() {
		return iddateretplan;
	}

	public void setIddateretplan(Date iddateretplan) {
		this.iddateretplan = iddateretplan;
	}

	public Date getIddateretact() {
		return iddateretact;
	}

	public void setIddateretact(Date iddateretact) {
		this.iddateretact = iddateretact;
	}

	public int getIdoverday() {
		return idoverday;
	}

	public void setIdoverday(int idoverday) {
		this.idoverday = idoverday;
	}

	public float getIdOvermoney() {
		return idOvermoney;
	}

	public void setIdOvermoney(float idOvermoney) {
		this.idOvermoney = idOvermoney;
	}

	public float getIdpunishmoney() {
		return idpunishmoney;
	}

	public void setIdpunishmoney(float idpunishmoney) {
		this.idpunishmoney = idpunishmoney;
	}

	public boolean isIshasreturn() {
		return ishasreturn;
	}

	public void setIshasreturn(boolean ishasreturn) {
		this.ishasreturn = ishasreturn;
	}

	public String getOperatorlend() {
		return operatorlend;
	}

	public void setOperatorlend(String operatorlend) {
		this.operatorlend = operatorlend;
	}

	public String getOperatorret() {
		return operatorret;
	}

	public void setOperatorret(String operatorret) {
		this.operatorret = operatorret;
	}

	
	
	

}
