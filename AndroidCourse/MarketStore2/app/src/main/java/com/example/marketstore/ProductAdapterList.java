package com.example.marketstore;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.security.ProtectionDomain;
import java.util.List;

public class ProductAdapterList extends RecyclerView.Adapter<ProductAdapterList.ProductViewHolder> {

    List<Product> listaProduto;
    List<Integer> listPurchasedItems;

    public ProductAdapterList(List<Product> product, List<Integer> listPurchasedItems) {
        this.listaProduto = product;
        this.listPurchasedItems = listPurchasedItems;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {

        holder.textViewProduto.setText(listaProduto.get(position).getProduct());
        holder.textViewDescricao.setText(listaProduto.get(position).getDescription());
        holder.textViewPrice.setText("R$: " + (String.valueOf(listaProduto.get(position).getPrice())));
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    listPurchasedItems.add(listaProduto.get(position).getId());
                } else {
                    listPurchasedItems.remove(listaProduto.get(position).getId());
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NavDirections aciton = ProductListFragmentDirections.actionProductListFragmentToFragmentProductDetail((listaProduto.get(position)));
                        Navigation.findNavController(v).navigate(aciton);
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProduto.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewProduto;
        TextView textViewDescricao;
        TextView textViewPrice;
        CheckBox checkBox;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewProduto = itemView.findViewById(R.id.textView_product);
            textViewDescricao = itemView.findViewById(R.id.textView_desc_product);
            textViewPrice = itemView.findViewById(R.id.textView_price);
            checkBox = itemView.findViewById(R.id.checkBox_selection);
        }
    }

}
