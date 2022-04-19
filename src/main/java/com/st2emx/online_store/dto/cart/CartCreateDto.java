package com.st2emx.online_store.dto.cart;

import com.st2emx.online_store.dto.AuditableDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * created by Elyor Ergashov
 *
 * @Author : elyor
 * @Date : 25/03/22
 * @Project : CazoStoreSite-master
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartCreateDto extends AuditableDto {
    private Long productId;
    private Long userId;
    private String productName;
    private Double price;
    private int count;
    private String image_path;
}
