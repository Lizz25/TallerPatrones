
public class Tecnico implements IHandler{
    private IHandler siguiente = null;
    
    public Tecnico (IHandler pSiguiente){
        siguiente = pSiguiente;
    }

    @Override
    public boolean cambiar_Producto(Producto producto, String fallo) {
        boolean cambio = false;
        //verificar que el producto se encuentra en periodo de garantía
        if(producto.garantia.fallos.contains(fallo)){
            cambio = siguiente.cambiar_Producto(producto, fallo);
        }else{
            return cambio;
        }
    }
    
    
}