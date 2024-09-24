package com.erp.springboot.backend.tool;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

public class utils {

    /**
     * Convierte un listado de objetos en paginas
     * @param listaCompleta lista de objetos
     * @param pageable informacion de la solicitud de la pagina
     * @return una pagina solicitada del listado de objetos
     * @param <T> tipo del objeto
     */
    public  <T> Page<T> convertirListaAPagina(List<T> listaCompleta, Pageable pageable) {
        int total = listaCompleta.size();
        int inicio = (int) pageable.getOffset();
        int fin = Math.min((inicio + pageable.getPageSize()), total);

        List<T> listaPaginada;

        if (inicio >= total) {
            listaPaginada = Collections.emptyList();
        } else {
            listaPaginada = listaCompleta.subList(inicio, fin);
        }

        return new PageImpl<>(listaPaginada, pageable, total);
    }
}
