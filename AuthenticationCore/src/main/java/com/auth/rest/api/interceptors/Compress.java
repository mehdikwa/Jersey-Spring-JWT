package com.auth.rest.api.interceptors;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.ws.rs.NameBinding;

//@Compress annotation is the name binding annotation
@NameBinding
@Retention(RetentionPolicy.RUNTIME)
public @interface Compress {}
