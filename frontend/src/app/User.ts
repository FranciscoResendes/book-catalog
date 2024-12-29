import { Book } from "./Book";

export interface User {
    id: number;
    username: string;
    email: string;
    password: string;
    role: string;
    books: Book[];
    date: Date;
    }