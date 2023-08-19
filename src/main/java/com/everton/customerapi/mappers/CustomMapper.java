package com.everton.customerapi.mappers;

import java.util.List;

public interface CustomMapper<S, D> {
    /**
     * Método para conversão do source para o destination
     *
     * @param source objeto para ser mapeado
     * @return objeto mapeado
     */
    D sourceToDestination(S source);

    /**
     * Conversão de lista.
     *
     * @param sourceList lista a ser mapeada
     * @return lista convertida
     */
    List<D> sourceToDestination(List<S> sourceList);

    /**
     * Método para conversão do destination para o source
     *
     * @param destination objeto para ser mapeado
     * @return objeto mapeado
     */
    S destinationToSource(D destination);

    /**
     * Conversão de lista.
     *
     * @param destinationList lista a ser mapeada
     * @return lista convertida
     */
    List<S> destinationToSource(List<D> destinationList);
}
