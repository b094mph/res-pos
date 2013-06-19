package com.res.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modifytaste", catalog="restaurant")
public class ModifyTaste implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="modifytasteid")
	private long modifyTasteId;

	@Column(name="modifytastename", nullable=false, unique=true, length=10)
	private String modifyTasteName;
	
	@Column(name="modifytastecname", length=10)
	private String modifyTasteCName;

	public long getModifyTasteId() {
		return modifyTasteId;
	}

	public void setModifyTasteId(long modifyTasteId) {
		this.modifyTasteId = modifyTasteId;
	}

	public String getModifyTasteName() {
		return modifyTasteName;
	}

	public void setModifyTasteName(String modifyTasteName) {
		this.modifyTasteName = modifyTasteName;
	}

	public String getModifyTasteCName() {
		return modifyTasteCName;
	}

	public void setModifyTasteCName(String modifyTasteCName) {
		this.modifyTasteCName = modifyTasteCName;
	}

}
