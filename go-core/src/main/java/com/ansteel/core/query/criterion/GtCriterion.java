package com.ansteel.core.query.criterion;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ansteel.core.query.QueryCriterion;

/**
 * 创 建 人：gugu
 * 创建日期：2015-04-25
 * 修 改 人：
 * 修改日 期：
 * 描   述： 一个工具类，作为查询条件。  
 */
public class GtCriterion implements QueryCriterion {
	
	private Comparable<?> value;
	private String propName;

	public GtCriterion(String propName, Comparable<?> value) {
		this.propName = propName;
		this.value = value;
	}

	public Comparable<?> getValue() {
		return value;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof GtCriterion))
			return false;
		GtCriterion castOther = (GtCriterion) other;
		return new EqualsBuilder()
			.append(this.getPropName(), castOther.getPropName())
			.append(value, castOther.value).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(getPropName()).append(value).toHashCode();
	}

	@Override
	public String toString() {
		return getPropName() + " > " + value;
	}

	public String getPropName() {
		return propName;
	}
	
	@Override
	public String getCriterionName() {
		return QueryCriterion.TYPE_GT;
	}

	@Override
	public String getExpre() {
		return PREFIX + getPropName() + " > :" + getPropName().replaceAll("\\.", "");
	}
	
	@Override
	public Object getPropValue() {
		return value;
	}
	
}
