package org.ryan.logging.domain.model.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Iriyanto.Perkasa on 1/24/2017.
 */
@Data
@ToString
public class GenericObject implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<GenericValue> values;

    public GenericObject() {}

}
