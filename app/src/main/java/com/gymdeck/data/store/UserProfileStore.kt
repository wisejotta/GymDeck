package com.gymdeck.data.store

import com.gymdeck.data.models.UserMetadata

object UserProfileStore {
    var metadata: UserMetadata? = null

    fun save(user: UserMetadata) {
        metadata = user
    }

    fun get(): UserMetadata? = metadata
}
