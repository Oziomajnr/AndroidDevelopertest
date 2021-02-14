package com.ozioma.dindinandroidtest.viewutils

import androidx.recyclerview.widget.DiffUtil
import com.ozioma.dindinandroidtest.data.StableItem

class HashItemCallback<T : StableItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem.hashCode() == newItem.hashCode()
}