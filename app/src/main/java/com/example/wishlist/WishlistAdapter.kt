import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R
import com.example.wishlist.WishlistItem

class WishlistAdapter(private val items: MutableList<WishlistItem>) : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.nameTextView.text = currentItem.name
        holder.linkTextView.text = currentItem.link
        holder.priceTextView.text = currentItem.price
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val linkTextView: TextView = itemView.findViewById(R.id.linkTextView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
    }


}
