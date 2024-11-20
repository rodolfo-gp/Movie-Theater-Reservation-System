export async function fetchMovies() {
    const response = await fetch("./movies.json");
    if (!response.ok) throw new Error("Failed to fetch movie data.");
    return response.json();
  }
  