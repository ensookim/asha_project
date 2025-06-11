import React from "react";

interface Product {
    productId: number;
    productName: string;
    description: string;
    imageUrl: string;
}

interface Props {
    product: Product;
}

const ProductDetailPage: React.FC<Props> = ({ product }) => {
    return (
        <div>
            <h1>{product.productName}</h1>
            <img src={product.imageUrl} alt={product.productName} style={{ maxWidth: "300px" }} />
            <p>{product.description}</p>
        </div>
    );
};

export default ProductDetailPage;
