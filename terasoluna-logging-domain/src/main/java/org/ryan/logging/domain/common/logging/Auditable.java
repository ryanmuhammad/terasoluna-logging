package org.ryan.logging.domain.common.logging;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Iriyanto.Perkasa on 1/23/2017.
 */
@Target({METHOD,TYPE})
@Retention(RUNTIME)
public @interface Auditable {
}
