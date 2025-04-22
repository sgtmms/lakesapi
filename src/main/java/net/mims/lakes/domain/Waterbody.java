package net.mims.lakes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.NumberFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * = Waterbody
 *
 * TODO Auto-generated class documentation
 *
 */
@Entity(name = "Waterbody")
@Table(name="waterbody", schema="public")
//@Table(uniqueConstraints=@UniqueConstraint(columnNames={"lakeName","acres", "latitude", "longitude"}))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Waterbody {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "waterbody_id")
    private Long id;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "version")
    private Integer version;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "statecode", length = 2)
    @Size(min = 2, max = 2)
    @NotNull
    private String stateCode;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "lakename" , length = 72)
    @Size(min = 0, max = 72)
    @NotNull
    private String lakeName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Double acres;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Double latitude;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NotNull
    @NumberFormat
    private Double longitude;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "countyname", length = 24)
    @Size(min = 2, max = 24)
    @NotNull
    private String countyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @Column(name = "statename", length = 24)
    @Size(min = 2, max = 24)
    @NotNull
	private String stateName;
      
    
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    	@JoinTable(name = "waterbody_fishspecies",
    	    joinColumns = @JoinColumn(name = "waterbody_id", referencedColumnName="waterbody_id"),
    	    inverseJoinColumns = @JoinColumn(name = "fishspecies_id", referencedColumnName="fishspecies_id")
    	)
	private Set<FishSpecies> fishSpecies = new HashSet<>();

	/**
	 * 
	 */
	public Waterbody() {
		
	}

	public Waterbody (String stateCode, String stateName, String countyName, String lakeName, Double acres, Double latitude, Double longitude){
		this.stateCode = stateCode;
		this.stateName = stateName;
		this.countyName = countyName;
		this.lakeName = lakeName;
		this.acres = acres;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the lakeName
	 */
	public String getLakeName() {
		return lakeName;
	}

	/**
	 * @param lakeName the lakeName to set
	 */
	public void setLakeName(String lakeName) {
		this.lakeName = lakeName;
	}

	/**
	 * @return the acres
	 */
	public Double getAcres() {
		return acres;
	}

	/**
	 * @param acres the acres to set
	 */
	public void setAcres(Double acres) {
		this.acres = acres;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the countyName
	 */
	public String getCountyName() {
		return countyName;
	}

	/**
	 * @param countyName the countyName to set
	 */
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;

	}

	public Set<FishSpecies> getFishSpeciesList(){
		return this.fishSpecies;
	} 

	public void setFishSpeciesList(Set<FishSpecies> fishSpecies){
		this.fishSpecies = fishSpecies;
	} 

	public boolean addFishSpeciesList(HashSet<FishSpecies> fishList){
		return this.fishSpecies.addAll(fishList);
	} 

	public boolean addFishSpecies(FishSpecies fish){
		return this.fishSpecies.add(fish);
	} 

	public boolean removeFishSpecies(FishSpecies fish){
		return this.fishSpecies.remove(fish);
	} 

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acres == null) ? 0 : acres.hashCode());
		result = prime * result + ((countyName == null) ? 0 : countyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lakeName == null) ? 0 : lakeName.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waterbody other = (Waterbody) obj;
		if (acres == null) {
			if (other.acres != null)
				return false;
		} else if (!acres.equals(other.acres))
			return false;
		if (countyName == null) {
			if (other.countyName != null)
				return false;
		} else if (!countyName.equals(other.countyName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lakeName == null) {
			if (other.lakeName != null)
				return false;
		} else if (!lakeName.equals(other.lakeName))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Waterbody [id=" + id + ", version=" + version + ", stateCode=" + stateCode + ", lakeName=" + lakeName
				+ ", acres=" + acres + ", latitude=" + latitude + ", longitude=" + longitude + ", countyName="
				+ countyName + ", stateName=" + stateName + "\n" +
				fishSpecies.toString() + "]";
	}
}

