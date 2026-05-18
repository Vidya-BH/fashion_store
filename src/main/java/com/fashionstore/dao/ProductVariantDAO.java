package com.fashionstore.dao;

import java.util.List;
import com.fashionstore.model.ProductVariant;

public interface ProductVariantDAO {

    // ================= CREATE =================
    boolean addVariant(ProductVariant variant);

    // ================= READ =================
    ProductVariant getVariantById(int variantId);
    List<ProductVariant> getVariantsByProductId(int productId);

    // Get specific variant (product + size)
    ProductVariant getVariantByProductAndSize(int productId, String size);

    // ================= UPDATE =================
    boolean updateVariant(ProductVariant variant);

    // Update stock only
    boolean updateStock(int variantId, int quantity);

    // ================= DELETE =================
    boolean deleteVariant(int variantId);
}