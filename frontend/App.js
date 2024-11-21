import { fetchMovies } from "./api.js";
import { renderMovies } from "./render.js";

document.addEventListener("DOMContentLoaded", () => {
  fetchMovies().then(renderMovies).catch(console.error);
});
