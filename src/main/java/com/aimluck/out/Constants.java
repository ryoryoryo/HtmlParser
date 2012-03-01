package com.aimluck.out;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Constants {
	private static final String BUNDLE_NAME = "constants"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Constants() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
