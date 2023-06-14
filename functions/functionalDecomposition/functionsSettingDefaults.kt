fun tip(bill: Int, percentage: Int = 10): Int {
    // TODO
    var tip = (percentage / 100.0) * bill
    return tip.toInt()
}