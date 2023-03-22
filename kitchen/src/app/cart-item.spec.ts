import { CartItem } from './cart-item';
import { ProductsComponent } from './products/products.component';

describe('CartItem', () => {
  it('should create an instance', () => {
    expect(new CartItem({})).toBeTruthy();
  });
});
