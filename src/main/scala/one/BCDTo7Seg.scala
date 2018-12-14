package one

import chisel3._
import chisel3.util._

class BCDTo7Seg extends Module {
  val io = IO(new Bundle {
    val bcd = Input(UInt(4.W))
    val seg = Output(UInt(7.W))
  })

  io.seg := MuxLookup(io.bcd, 0x3F.U, Array(
    0.U -> 0x40.U,
    1.U -> 0x79.U,
    2.U -> 0x24.U,
    3.U -> 0x14.U,
    4.U -> 0x19.U,
    5.U -> 0x12.U,
    6.U -> 0x02.U,
    7.U -> 0x78.U,
    8.U -> 0x00.U,
    9.U -> 0x10.U,
    15.U -> 0x7F.U
  ))
}

object BCDTo7SegMain extends App {
  chisel3.Driver.execute(args, () => new BCDTo7Seg)
}

object BCDTo7SegRepl extends App {
  iotesters.Driver.executeFirrtlRepl(args, () => new BCDTo7Seg)
}
