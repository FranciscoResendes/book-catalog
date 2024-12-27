import { Book } from "./Book";

export interface User {
    id: number;
    name: string;
    email: string;
    password: string;
    role: string;
    books: Book[];
    date: Date;
    }