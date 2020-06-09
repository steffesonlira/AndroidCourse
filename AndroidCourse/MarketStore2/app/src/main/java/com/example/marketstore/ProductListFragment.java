package com.example.marketstore;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.marketstore.databinding.FragmentProductDetailBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {

    List<Product> product = new ArrayList<>();
    List<Integer> idProdutosComprados = new ArrayList<>();

    List<Product> produtosComprados = new ArrayList<>();

    RecyclerView recyclerView;


    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_list, container, false);
        gerarProduto();

        ProductAdapterList adapter = new ProductAdapterList(product, idProdutosComprados);
        recyclerView = v.findViewById(R.id.recyclerView_product_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        setHasOptionsMenu(true);

        return v;

    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.shop_cart, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menu_shop_cart) {
            selecionarProdutoCompradoPorId();
            NavDirections action = ProductListFragmentDirections.actionProductListFragmentToPurshaseListFragment2(
                    produtosComprados.toArray(new Product[produtosComprados.size()]));
            Navigation.findNavController(getView()).navigate(action);
        }

        return super.onOptionsItemSelected(item);
    }

    private void gerarProduto() {
        Product products;
        for (int i = 0; i < 10; i++) {
            products = new Product(i, "produto " + i, "Descricao " + i + " do Produto"
                    + i, "Longa descricao " + i + " do Produto" + i, 2f);
            product.add(products);
        }
    }


    private void selecionarProdutoCompradoPorId() {
        for (int id : idProdutosComprados) {
            for (Product product : product) {
                if (id == product.getId()) {
                    produtosComprados.add(product);
                }
            }
        }

    }
}
