package com.cxt.esl.sale.activity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.cxt.esl.R;
import com.cxt.esl.sale.adapter.SaleAdapter;
import com.cxt.esl.sale.dao.OrderDao;
import com.cxt.esl.sale.domain.Order;
import com.cxt.esl.sale.domain.SaleItem;
import com.cxt.esl.util.db.ESLDatebaseHelper;

public class ShoppingCartActivity extends Activity {

	private List<SaleItem> saleList;
	private SaleAdapter adapter;
	private EditText etGoodsPrice;
	private EditText etUserPay;
	private Button checkOutBtn;

	private ESLDatebaseHelper helper;
	private OrderDao orderDao;

	private float allPrice;

	private void init() {
		try {
			helper = ESLDatebaseHelper.getHelper(this);
			orderDao = new OrderDao(helper.getOrderDao());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		saleList = getIntent().getParcelableArrayListExtra("saleList");

		etGoodsPrice = (EditText) findViewById(R.id.e_goods_price);
		etUserPay = (EditText) findViewById(R.id.e_user_pay);
		checkOutBtn = (Button) findViewById(R.id.check_out_btn);
		for (SaleItem s : saleList) {
			allPrice += s.getGood().getPresPrice() * s.getCount();
		}
		etGoodsPrice.setText("" + allPrice);

		checkOutBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String strPay = etUserPay.getText().toString().trim();
				String strGoodsPrice = etGoodsPrice.getText().toString().trim();
				if (saleList == null || saleList.size() <= 0) {
					Toast.makeText(ShoppingCartActivity.this, "���ﳵΪ�գ�",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (!(strGoodsPrice.matches("^[0-9]*$") || strGoodsPrice
						.matches("^\\d+(\\.\\d+)?$"))) {
					Toast.makeText(ShoppingCartActivity.this, "��Ʒ�ܼ۱���������",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (strPay.length() <= 0) {
					Toast.makeText(ShoppingCartActivity.this, "����֧�����",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (!(strPay.matches("^[0-9]*$") || strPay
						.matches("^\\d+(\\.\\d+)?$"))) {
					Toast.makeText(ShoppingCartActivity.this, "֧��������������",
							Toast.LENGTH_SHORT).show();
					return;
				}
				allPrice = Float.valueOf(strGoodsPrice);
				final float pay = Float.valueOf(strPay);
				if (pay < allPrice) {
					Toast.makeText(ShoppingCartActivity.this, "֧������",
							Toast.LENGTH_SHORT).show();
					return;
				}


				AlertDialog.Builder d2 = new AlertDialog.Builder(
						ShoppingCartActivity.this);
				d2.setTitle("ȷ������");
				d2.setMessage("ȷ������,�һ���Ǯ��"+(pay - allPrice) + "Ԫ");
				d2.setCancelable(false);
				d2.setNegativeButton("��",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
							}
						});
				d2.setPositiveButton("��",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Order o = new Order();
								o.setAllPrice(allPrice);
								o.setChange(pay - allPrice);
								o.setCreateDate(new Date());
								o.setOperator("��������Ա");
								o.setUserPay(pay);
								String goods = "";
								for (SaleItem s : saleList) {
									goods += s.getGood().getPosName() + "__"
											+ s.getGood().getPresPrice() + "__"
											+ s.getCount() + ";";
								}
								o.setGoods(goods);
								try {
									orderDao.insert(o);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								Toast.makeText(ShoppingCartActivity.this,
										"��ɹ���", Toast.LENGTH_SHORT).show();
								
								saleList = new ArrayList<SaleItem>();
								adapter = new SaleAdapter(ShoppingCartActivity.this,
										R.layout.sale_item, saleList);
								ListView listView = (ListView) findViewById(R.id.sale_list);
								listView.setAdapter(adapter);
								etGoodsPrice.setText("0.0");
								etUserPay.setText("0.0");

							}
						});
				d2.show();

			}
		});

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shopping_cart);
		init();

		adapter = new SaleAdapter(ShoppingCartActivity.this,
				R.layout.sale_item, saleList);
		ListView listView = (ListView) findViewById(R.id.sale_list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new SaleItemClickListener(
				R.layout.sale_item));

	}

	private class SaleItemClickListener implements OnItemClickListener {
		private int resourceId;

		SaleItemClickListener(int resourceId) {
			this.resourceId = resourceId;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			view = LayoutInflater.from(ShoppingCartActivity.this).inflate(
					resourceId, null);
			final SaleItem s = saleList.get(position);

			AlertDialog.Builder d = new AlertDialog.Builder(
					ShoppingCartActivity.this);
			d.setTitle("�޸Ĺ�������:");
			d.setMessage("���빺������:0����ɾ������Ʒ");
			d.setCancelable(false);
			d.setNegativeButton("��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			final EditText etCount = new EditText(ShoppingCartActivity.this);
			etCount.setText(s.getCount() + "");
			etCount.setTextSize(15);
			d.setView(etCount);
			d.setPositiveButton("��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String strCount = etCount.getText().toString();
					if (strCount.length() <= 0) {
						Toast.makeText(ShoppingCartActivity.this, "���빺������",
								Toast.LENGTH_SHORT).show();
						return;
					}
					if (!strCount.matches("^[0-9]*$")) {
						Toast.makeText(ShoppingCartActivity.this, "������������������",
								Toast.LENGTH_SHORT).show();
						return;
					}
					int count = Integer.valueOf(strCount);
					if (count == 0) {
						saleList.remove(s);
						Toast.makeText(ShoppingCartActivity.this, "ɾ���ɹ�",
								Toast.LENGTH_SHORT).show();
					} else {
						saleList.remove(s);
						s.setCount(count);
						saleList.add(s);
						Toast.makeText(ShoppingCartActivity.this, "�޸ĳɹ�",
								Toast.LENGTH_SHORT).show();
					}

					adapter = new SaleAdapter(ShoppingCartActivity.this,
							R.layout.sale_item, saleList);
					ListView listView = (ListView) findViewById(R.id.sale_list);
					listView.setAdapter(adapter);
					allPrice = 0.0f;
					for (SaleItem s : saleList) {
						allPrice += s.getGood().getPresPrice();
					}
					etGoodsPrice.setText(""+allPrice);
				}
			});
			d.show();

		}

	}
}
