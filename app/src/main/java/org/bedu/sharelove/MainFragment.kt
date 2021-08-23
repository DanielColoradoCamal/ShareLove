package org.bedu.sharelove

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_minuta.*
import kotlinx.android.synthetic.main.fragment_minuta.view.*


class MainFragment : Fragment() {

private var listener : (Product) ->Unit = {}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_minuta, container, false)
        // seteando el appbar como action bar
        //val appBar = view.findViewById<Toolbar>(R.id.app_bar)
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        // Inflate the layout for this fragment

        // Setup Drawer
        val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val drawerToggle = ActionBarDrawerToggle(activity,drawerLayout,view.app_bar,R.string.open_drawer,R.string.close_drawer)

        setUpRecyclerView(view)

        return view
    }

//

    //asignamos las acciones para cada opción del AppBar


    private fun getProducts(): MutableList<Product>{
        var products:MutableList<Product> = ArrayList()

        products.add(Product("cafetera", "Regalo cafetera, favor de mandar mensaje para acordar el punto de encuentro", "2",4.6f,R.drawable.cafetera))
        products.add(Product("2 kilos de frutas", "Estan en buenas condiciones, tengo mas kilos por si alguien quiere puede venir por ellas", "12",4.4f,R.drawable.fruta))
        products.add(Product("harina de hotcakes", "Regalo harina de hotcakes, estoy por la colonia centro, favor de mandarme privado entrego de 10am a 12pm", "10",3.8f,R.drawable.hotcakes))
        products.add(Product("crema avon", "Tengo esta crema para manos, a mi me irrito, si a alguien le sirve, por favor pasen por ella", "5",4.8f,R.drawable.crema))
        products.add(Product("pequeña despensa", "Regalo algunas cositas, tengo varias cosas de despensa, espero que a alguien mas les puedan servir", "5",4.8f,R.drawable.knorr))
        products.add(Product("maleta", "tengo esta maleta que no tengo espacio para tenerla aqui, si pueden pasar mandenme mensaje, la tengo en colonia centro", "2",4.8f,R.drawable.maleta))
        products.add(Product("llantas rin 14 media vida", "Hola tengo estas llantas, tiene media vida, son 2, compre en promocion las 4 pero estas estas estan en buen estado ", "3",4.8f,R.drawable.llanta))
        products.add(Product("bonita mochila de gatitos", "regalo esta bonita mochila de gatitos, espero les sirva", "6",4.8f,R.drawable.mochilagato))
        products.add(Product("juego de peines", "Regalo juego de peines y cepillos, estan nuevos, manden mensaje", "1",4.8f,R.drawable.peine))
        products.add(Product("paquete de paepel sanitario", "Hola regalo este paquete de papel sanitario, lo pueden recoger, en el parque, solo manden mensaje", "1",4.8f,R.drawable.petalo))
        products.add(Product("cubetas de grava", "Hola, estabamos haciendo remodelación en mi casa y tengo esta grava que me sobro, son 4 cubetas si a alguien le sirven pueden pasar por ella.", "1",4.8f,R.drawable.piedras))
        products.add(Product("playera lacoste", "Hola, tengo esta playera, no me quedo y ya no la puedo cambiar, si te queda sera tuya, ando por colonia centro", "1",4.8f,R.drawable.playera))
        products.add(Product("ropa de mujer", "Hola, tengo esta ropa de mujer son varias prendas, es de segunda mano, si te queda sera tuya, ando por colonia centro", "1",4.8f,R.drawable.ropa))
        products.add(Product("despensa", "Hola, tengo esta pequeña despensa y quisiera ayudar, es mi primer publicación, estoy por colonia centro", "1",4.8f,R.drawable.salsa))
        products.add(Product("shampoo nuevo", "Hola, tengo este shampoo a mi no me sirvio, solo lo use una vez, esta lleno, espero a alguien le pueda servir", "1",4.8f,R.drawable.shampoo))
        products.add(Product("silla para niña", "si alguien la quiere esta como nueva, pero mi hija ya esta grende, pueden pasar por ella", "1",4.8f,R.drawable.silla))
        products.add(Product("mochila escolar", "hola, tengo esta mochila es color rosita esta como nueva, pero mi hija ya salio de la escuela, pueden pasar por ella", "3",4.8f,R.drawable.mochilarosa))
        products.add(Product("paquete de pañales y toallitas", "buenos dias, tengo este paquete de pañales es talla 5 y las toallitas, espero pueda ayudar a alguien, estoy por la colonia centro", "3",4.8f,R.drawable.cosasbebe))
        products.add(Product("tengo un litro de aceite", "tengo este litro de aceite, espero pueda ayudar a alguien, estoy por la colonia centro", "3",4.8f,R.drawable.aceite))
        products.add(Product("bañito para bebe", "hola amigos, tengo este bañito era de mi bebe, pero ya no lo usa, espero le sirva a alguien de aqui", "3",4.8f,R.drawable.baniobebe))

        return products
    }
 fun setListener(l: (Product) ->Unit){
        listener = l
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun setUpRecyclerView(view: View){
        val recyclerProducts = view.recyclerProducts
        recyclerProducts.setHasFixedSize(true)
        recyclerProducts.layoutManager = GridLayoutManager(
            activity,
            1,
            GridLayoutManager.VERTICAL,
            false
        )


        val largePadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.product_grid_spacing_small)
        recyclerProducts.addItemDecoration(GridDecoration(largePadding, smallPadding))

        //seteando el Adapter
        recyclerProducts.adapter = RecyclerAdapter( activity!!, getProducts(),clickListener = {

        })
    }

}