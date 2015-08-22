package com.example.ali.moodlamp;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;



import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends Activity {


    TextView myLabel;
    EditText myDevice;
    BluetoothAdapter btAdapter;
    BluetoothSocket btSocket;
    BluetoothDevice btDevice;
    OutputStream outStream;
    InputStream inStream;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button openButton = (Button) findViewById(R.id.open);
        Button green = (Button) findViewById(R.id.greenB);
        Button red = (Button) findViewById(R.id.redB);
        Button blue = (Button) findViewById(R.id.blueB);
        Button purple = (Button) findViewById(R.id.purpleB);
        Button maroon = (Button) findViewById(R.id.maroonB);
        Button v = (Button) findViewById(R.id.vB);
        Button yellow = (Button) findViewById(R.id.yellowB);
        Button white = (Button) findViewById(R.id.whiteB);
        Button dgreen = (Button) findViewById(R.id.dgreenB);
        Button lb = (Button) findViewById(R.id.lbB);
        Button db = (Button) findViewById(R.id.dbB);
        Button orange = (Button) findViewById(R.id.orangeB);
        Button rainbow = (Button) findViewById(R.id.rainB);
        Button off = (Button) findViewById(R.id.offB);
        Button Close = (Button) findViewById(R.id.close);

        myLabel = (TextView) findViewById(R.id.label);
        myDevice = (EditText)findViewById(R.id.deviceName);

        // When the button is clicked it launches the findBT method which
        // detects if the bluetooth module is available
        // Finally once the findBT has determined that the bluetooth connection
        // is available it connects the two devices together
        openButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    findBT();
                    openBT();
                } catch (IOException ex) {
                }
            }

        });


        //Just buttons that send the message to the Arduino and run which motor that the message is associated with
        green.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    try {
                        greenButton();
                    } catch (IOException ex) {
                    }
                }
                return false;
            }
            //return false;
        });

        red.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    try {
                        redButton();
                    } catch (IOException ex) {
                    }
                }

                return false;
            }
            //return false;
        });

        blue.setOnTouchListener(new View.OnTouchListener() {
                                    @Override
                                    public boolean onTouch(View v, MotionEvent event) {

                                        if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                            try {
                                                blueButton();
                                            } catch (IOException ex) {
                                            }
                                        }
                                        return false;
                                    }
                                    //return false;
                                }

        );

        purple.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  purpleButton();
                                              } catch (IOException ex) {
                                              }
                                          }
                                          return false;
                                      }
                                      //return false;
                                  }


        );


        maroon.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  maroonButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }


        );

        v.setOnTouchListener(new View.OnTouchListener() {
                                 @Override
                                 public boolean onTouch(View v, MotionEvent event) {

                                     if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                         try {
                                             vButton();
                                         } catch (IOException ex) {
                                         }
                                     }/* else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                     return false;
                                 }
                                 //return false;
                             }

        );

        yellow.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  yellowButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }

        );

        white.setOnTouchListener(new View.OnTouchListener() {
                                     @Override
                                     public boolean onTouch(View v, MotionEvent event) {

                                         if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                             try {
                                                 whiteButton();
                                             } catch (IOException ex) {
                                             }
                                         } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                         return false;
                                     }
                                     //return false;
                                 }

        );

        dgreen.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  dgreenButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }

        );

        lb.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  lbButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }

        );

        db.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  dbButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }

        );

        orange.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  orangeButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }

        );

        rainbow.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                              try {
                                                  rainButton();
                                              } catch (IOException ex) {
                                              }
                                          } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                          return false;
                                      }
                                      //return false;
                                  }

        );

        off.setOnTouchListener(new View.OnTouchListener() {
                                       @Override
                                       public boolean onTouch(View v, MotionEvent event) {

                                           if (event.getAction() == MotionEvent.ACTION_DOWN) {

                                               try {
                                                   offButton();
                                               } catch (IOException ex) {
                                               }
                                           } /*else if (event.getAction() == MotionEvent.ACTION_UP) {

					try {
						stopMotor();
					} catch (IOException ex) {
					}*/
                                           return false;
                                       }
                                       //return false;
                                   }

        );

        Close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);
            }
        });

    }


    //Looks for and connects to the bluetooth module
    void findBT() {
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            myLabel.setText("No bluetooth adapter available");
        }

        if (!btAdapter.isEnabled()) {
            Intent enableBluetooth = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }

        Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                String pairedDeviceName = myDevice.getText().toString();
                if (device.getName().equals(pairedDeviceName)) {
                    btDevice = device;
                    break;
                }
            }
        }
        myLabel.setText("Bluetooth Device Found");
    }

    // Connects the two devices together
    void openBT() throws IOException {
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); // Standard
        // SerialPortService
        // ID
        btSocket = btDevice.createRfcommSocketToServiceRecord(uuid);
        btSocket.connect();
        outStream = btSocket.getOutputStream();
        inStream = btSocket.getInputStream();

        myLabel.setText("Bluetooth Connected");
    }

    void redButton() throws IOException {
        String msg = "r";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void greenButton() throws IOException {
        String msg = "g";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void blueButton() throws IOException {
        String msg = "b";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void purpleButton() throws IOException {
        String msg = "p";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void maroonButton() throws IOException {
        String msg = "m";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void offButton() throws IOException {
        String msg = "q";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void vButton() throws IOException {
        String msg = "v";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void whiteButton() throws IOException {
        String msg = "w";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void yellowButton() throws IOException {
        String msg = "y";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void dgreenButton() throws IOException {
        String msg = "d";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void lbButton() throws IOException {
        String msg = "l";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void dbButton() throws IOException {
        String msg = "z";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void orangeButton() throws IOException {
        String msg = "o";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }

    void rainButton() throws IOException {
        String msg = "a";
        msg += "\n";
        outStream.write(msg.getBytes());
        myLabel.setText("Data Sent");
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
