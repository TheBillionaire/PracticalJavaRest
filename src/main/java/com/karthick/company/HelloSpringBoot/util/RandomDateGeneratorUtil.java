package com.karthick.company.HelloSpringBoot.util;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateGeneratorUtil {
	
	private static final long MINDATE = LocalDate.of(1989, Month.MARCH, 15).toEpochDay();
 	
	private static final long MAXDATE = LocalDate.now().toEpochDay();
	
	
	public static LocalDate randomDateGenerator() {
		return LocalDate.ofEpochDay(MINDATE + ThreadLocalRandom.current() .nextLong(MAXDATE-MINDATE));
	}
	
	
}
