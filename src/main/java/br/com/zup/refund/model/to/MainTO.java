package br.com.zup.refund.model.to;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

abstract class MainTO <T,X> {
    
    public List<T> mapList(List<X> objects){
        List<T> list = new ArrayList<T>();
        objects.stream().forEach(obj -> {
            list.add(map(obj));
        });
        return list;
    }
    
    @SuppressWarnings("unchecked")
    public T map(X object) {
        return (T) new ModelMapper().map(object, getMyType());
    }
    
    @SuppressWarnings("unchecked")
    public Class<?> getMyType() {
        return ((T) this).getClass();
    }
}
