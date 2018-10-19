package pe.jrivera6.paginasamarillasapp.repositories;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.jrivera6.paginasamarillasapp.models.Empresa;

public class EmpresaRepository {

    private static List<Empresa> empresas;

    static {
        empresas = new ArrayList<>();
        empresas.add(new Empresa(1, "Restaurantes", "La casa del tacu tacu", "Jr. Pelotillehue 53-48 Int 84", 012242625, "informes@lacasadeltacutacu.com", "www.lacasadeltacutacu.com", "logo_empresa1", "Déjese cautivar por el mejor sabor criollo…"));
        empresas.add(new Empresa(2, "Discotecas", "El embrujo", "Av. Metropolina 98", 351546488, "elembrujo@email.com", "www.elembrujo.com", "logo_empresa2", "Venga a la mejor discoteca de santa anita con atencion A1 de chicas venezolanas"));
        empresas.add(new Empresa(3, "Restaurantes", "La gran concha", "Av. Los Cedros 648", 946743422, "lagran@concha.com", "www.lagranconcha.com", "logo_empresa3", "Prueba una gran variedad de pescados y mariscos..."));
        empresas.add(new Empresa(4, "Restaurantes", "Mis costillitas", "Los ficus 146", 99846431, "miscostillitas@gmail.com", "www.miscostillitas.com", "logo_empresa4", "Prueba las mejores costillas de todo lima..."));
        empresas.add(new Empresa(5, "Veterinarias", "AmigoAnimales", "Av. Julio C. Tello 1654", 98761355, "amigodelos@animales.com", "www.amigoanimales.com", "logo_empresa5", "Veterinaria ubicada con herramientas de ultima generacion y gran atencion."));
        empresas.add(new Empresa(6, "Discotecas", "Rustica", "Av. Amancaes 154", 948943133, "rustica@hotmail.com", "www.rustica.com", "logo_empresa8", "Diviertete con musica y comida variada"));
        empresas.add(new Empresa(7, "Hoteles", "Asturias", "Av. Peru 155", 98794622, "hotelasturias.email.com", "www.hotelasturias.com", "logo_empresa7", "Ven a disfrutar con habitaciones matrimoniales, yacuzzi, agua caliente y maaaas"));
        empresas.add(new Empresa(8, "Veterinarias",  "Doctor Vet", "Av. Los alizos 88", 66998654, "doctorvet@emial.com", "www.docotorvet.com", "logo_empresa8", "El mejor veterinario de todos los tiempos"));
        empresas.add(new Empresa(9, "Restaurantes", "Pardos", "Av. Nicolas Ayllon Mall Santa Anita", 88584654, "pardoschicken@gmail.com", "www.pardoschicken.com", "logo_empresa9", "Los mejores pollos de todo el mall de santa anita ven y llevate una gaseosa gratis"));
        empresas.add(new Empresa(10, "Hoteles", "Virgo", "Jr. Juan Vasadre 169", 61359979, "hotel@virgo.com", "www.hotelvirgo.com", "logo_empresa10", "Diviertete con atencion A1, Tv 41' y Netflix"));

    }

    /*public static List<Empresa> getEmpresas() {
        return empresas;
    }*/

    public static List<Empresa> getFiltro(String nombre) {

        Log.e("getFiltro: ", nombre);

        List<Empresa> listaFiltrada = new ArrayList<>();

        for (Empresa e : empresas) {

            if (e.getCategoria().toLowerCase().contains(nombre) ) {
                listaFiltrada.add(e);
            }
        }
        return listaFiltrada;
    }

    public static Empresa buscarId(int id){

        Empresa emp = null;

        for(Empresa e : empresas){
            if (e.getId() == id){
                emp = e;
            }
        }
        Log.e( "buscarId: ", ""+emp.getNombre());
        return emp;
    }

}
