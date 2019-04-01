package com.apexlegendsat.springmvc.frontend.view;

public class WeaponView {
	private int id;
	private String name;
	private String type;
	private String imageSource;
	private int lowDps;
	private int highDps;
	private int clipSize;
	private float reloadTime;
	private float fireRate;
	private float raiseTime;
	private int damageRank;
	private int speedRank;
	private int rangeRank;
	private int accuracyRank;
	private int headShot;
	private int bodyShot;

	public WeaponView() {

	}

	public WeaponView(int id, String name, String type, String imageSource, int lowDps, int highDps, int clipSize,
			float reloadTime, float fireRate, float raiseTime, int damageRank, int speedRank, int rangeRank,
			int accuracyRank, int headShot, int bodyShot) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageSource = imageSource;
		this.lowDps = lowDps;
		this.highDps = highDps;
		this.clipSize = clipSize;
		this.reloadTime = reloadTime;
		this.fireRate = fireRate;
		this.raiseTime = raiseTime;
		this.damageRank = damageRank;
		this.speedRank = speedRank;
		this.rangeRank = rangeRank;
		this.accuracyRank = accuracyRank;
		this.headShot = headShot;
		this.bodyShot = bodyShot;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public int getLowDps() {
		return lowDps;
	}

	public void setLowDps(int lowDps) {
		this.lowDps = lowDps;
	}

	public int getHighDps() {
		return highDps;
	}

	public void setHighDps(int highDps) {
		this.highDps = highDps;
	}

	public int getClipSize() {
		return clipSize;
	}

	public void setClipSize(int clipSize) {
		this.clipSize = clipSize;
	}

	public float getReloadTime() {
		return reloadTime;
	}

	public void setReloadTime(float reloadTime) {
		this.reloadTime = reloadTime;
	}

	public float getFireRate() {
		return fireRate;
	}

	public void setFireRate(float fireRate) {
		this.fireRate = fireRate;
	}

	public float getRaiseTime() {
		return raiseTime;
	}

	public void setRaiseTime(float raiseTime) {
		this.raiseTime = raiseTime;
	}

	public int getDamageRank() {
		return damageRank;
	}

	public void setDamageRank(int damageRank) {
		this.damageRank = damageRank;
	}

	public int getSpeedRank() {
		return speedRank;
	}

	public void setSpeedRank(int speedRank) {
		this.speedRank = speedRank;
	}

	public int getRangeRank() {
		return rangeRank;
	}

	public void setRangeRank(int rangeRank) {
		this.rangeRank = rangeRank;
	}

	public int getAccuracyRank() {
		return accuracyRank;
	}

	public void setAccuracyRank(int accuracyRank) {
		this.accuracyRank = accuracyRank;
	}

	public int getHeadShot() {
		return headShot;
	}

	public void setHeadShot(int headShot) {
		this.headShot = headShot;
	}

	public int getBodyShot() {
		return bodyShot;
	}

	public void setBodyShot(int bodyShot) {
		this.bodyShot = bodyShot;
	}

	@Override
	public String toString() {
		return "WeaponView [id=" + id + ", name=" + name + ", type=" + type + ", imageSource=" + imageSource
				+ ", lowDps=" + lowDps + ", highDps=" + highDps + ", clipSize=" + clipSize + ", reloadTime="
				+ reloadTime + ", fireRate=" + fireRate + ", raiseTime=" + raiseTime + ", damageRank=" + damageRank
				+ ", speedRank=" + speedRank + ", rangeRank=" + rangeRank + ", accuracyRank=" + accuracyRank
				+ ", headShot=" + headShot + ", bodyShot=" + bodyShot + "]";
	}
}
