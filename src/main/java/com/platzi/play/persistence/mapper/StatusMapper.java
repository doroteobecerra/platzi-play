package com.platzi.play.persistence.mapper;

public class StatusMapper {

    public static Boolean stringToBoolean(String estado){
        if(estado == null) return null;

        return switch (estado.toUpperCase()){
            case "D" -> true;
            case "N" -> false;
            default -> null;
        };
    }
}
