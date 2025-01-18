import { Author } from "./Author";

export interface Book {
    isbn: string;
    title: string;
    author: Author;
    genre: string;
    pages: number;
    chaptersRead: number;
    status: string;
    score: number;
    synopsis: string;
    cover: string;
}