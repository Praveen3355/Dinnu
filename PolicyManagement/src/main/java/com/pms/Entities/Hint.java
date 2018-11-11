package com.pms.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hint")
public class Hint {
@Id
@Column(name="hint_id")
 private int hintId;

@OneToMany(mappedBy="hint")
private List<Mainuser> user = new ArrayList<>();
@Column(name="hint_des")
private String hintDes;

public int getHintId() {
	return hintId;
}
public void setHintId(int hintId) {
	this.hintId = hintId;
}
public List<Mainuser> getUser() {
	return user;
}
public void setUser(List<Mainuser> user) {
	this.user = user;
}
public String getHintDes() {
	return hintDes;
}
public void setHintDes(String hintDes) {
	this.hintDes = hintDes;
}
public void setHint_id(int hint_id) {
	this.hintId = hint_id;
}
public String getHint_des() {
	return hintDes;
}
public void setHint_des(String hint_des) {
	this.hintDes = hint_des;
}

}
