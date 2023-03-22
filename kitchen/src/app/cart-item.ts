import { Product } from "src/kitchenStory-api/src/models/product";



export class CartItem {
    category?: string;
    id?: number;
    name?: string;
    price: any;
    quantity:number;
    constructor(product: Product) {
        this.id = product.id;
        this.name = product.name;
        this.price = product.price;
        this.category= product.category;

        this.quantity = 1;
    }
}
