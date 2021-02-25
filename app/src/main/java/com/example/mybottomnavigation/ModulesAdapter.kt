package com.example.mybottomnavigation

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mybottomnavigation.databinding.ItemHomeBinding
import com.example.mybottomnavigation.model.MyModel

private val TAG = ModulesAdapter::class.java.simpleName
class ModulesAdapter(private val context: Context): ListAdapter<MyModel, ModulesAdapter.ModelViewHolder>(DiffCallback) {

    lateinit var onItemClickListener: (MyModel) -> Unit

    //Hacemos uso de DiffCallback pa identificar que item se agregó o borró es lo mismo siempre
    companion object DiffCallback: DiffUtil.ItemCallback<MyModel>() {

        override fun areItemsTheSame(oldItem: MyModel, newItem: MyModel): Boolean {
            return oldItem.id == newItem.id //igualamos si el item nuevo con el viejo es el mismo
        }

        override fun areContentsTheSame(oldItem: MyModel, newItem: MyModel): Boolean {
            return oldItem == newItem //para igualar modelos debe de ser una data class
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context)) //hacerlo extension functions
        return ModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val myModel = getItem(position)
        holder.bind(myModel)
    }

    inner class ModelViewHolder(private val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(myModel: MyModel) = with(binding) {



            txtTitle.text = myModel.text
            root.setOnClickListener {
                if (::onItemClickListener.isInitialized) {
                    onItemClickListener(myModel)
                }else {
                    Log.e(TAG, "onItemClickListener no inicializado")
                }
            }
            executePendingBindings()
        }
    }
}