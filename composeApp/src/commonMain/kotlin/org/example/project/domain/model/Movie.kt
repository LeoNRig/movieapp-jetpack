package org.example.project.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterURL: String,
    val genres: List<Genre>?,
    val year: Int,
    val duration: String?,
    val rating: String,
    val castMembers: List<CastMember>?
)


val movie1 = Movie(
    id = 1,
    title = "Minecraft ainda",
    overview = "Movie Overview",
    posterURL = "https://example.com/poster1.jpg",
    genres = listOf(genre1,genre2),
    year = 2022,
    duration = "2h 36 min",
    rating = "8.5",
    castMembers = listOf(
        castMember1,
        castMember2,
    )
)
