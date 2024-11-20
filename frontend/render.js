export function renderMovies(movies) {
    const container = document.getElementById("movie-list");
    container.innerHTML = movies.map(createMovieCard).join("");
  }
  
  function createMovieCard(movie) {
    return `
      <div class="movie-card">
        <img src="${movie.poster}" alt="${movie.title}">
        <h3>${movie.title}</h3>
        <p>${movie.genre.join(", ")}</p>
        <button onclick="location.href='movie.html?id=${movie.id}'">View Details</button>
      </div>
    `;
  }
  